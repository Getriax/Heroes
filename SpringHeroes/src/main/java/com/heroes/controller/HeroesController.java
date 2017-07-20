package com.heroes.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.heroes.dao.HeroDAO;
import com.heroes.dao.ItemDAO;
import com.heroes.model.Hero;
import com.heroes.model.Item;
import com.heroes.service.DropBoxService;

@Controller
@EnableWebMvc
public class HeroesController 
{
	@Autowired
	HeroDAO heroDAO;
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	DropBoxService DbxService;
	@Value("${package}")
	String nazwa;
	
	@RequestMapping("/lista")
	public String heroList(Model model)
	{
	
		System.out.println(DbxService.getAuthorizeUrl());
		List<Hero> heroes = new ArrayList<>();
		heroDAO.findAll().forEach(e -> heroes.add(e));
		model.addAttribute("heroes", heroes);
		return "lista";
	}
//	@RequestMapping("/bhalo")
//	public String bhalo()
//	{
//		return "halo";
//	}
//	@RequestMapping("/halo")
//	public String halo(@RequestParam(value="plik", required=false) MultipartFile file)
//	{
//			System.out.println(file.getOriginalFilename());
//			return "redirect:/lista.htm";	
//	}
	@RequestMapping("/admin/bdodaj")
	public String bHero(@ModelAttribute("heroDto") Hero hero, Model model)
	{
		model.addAttribute("heroDto", hero);
		return "dodaj";
	}
	@RequestMapping("/admin/dodaj")
	public String addHero(@ModelAttribute("heroDto") @Valid Hero heroDto, @RequestParam("plik") MultipartFile file)
	{	
			UUID uuid = UUID.randomUUID();
			String name = file.getOriginalFilename().split("\\.")[0];
			String extension = file.getOriginalFilename().split("\\.")[1];
			String fileName = name + uuid.toString() +"."+ extension;
			DbxService.uploadFile(file, fileName);
			heroDto.setFileName(fileName);
			System.out.println(file);
			System.out.println("Dodaje bohatera: " + heroDto);
			heroDAO.save(heroDto);
			return "redirect:/lista.htm";	
	}
	
	@RequestMapping("/hero-{id}")
	public String heroDetail(@PathVariable("id") Integer id, Model model)
	{
		Hero hero = heroDAO.findOne(id);
		model.addAttribute("img", DbxService.getFile(hero.getFileName()));
		model.addAttribute("hero", hero);
		return "szczegoly";
	}
	
	@RequestMapping("/admin/additem-{heroId}")
	public String addItem(@PathVariable("heroId") Integer heroId, HttpServletRequest request,@ModelAttribute("item") @Valid Item item, BindingResult result)
	{
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors())
		{
			if (heroDAO.findOne(heroId) == null)
				return "additem";
			item.setHero(heroDAO.findOne(heroId));
			itemDAO.save(item);
			return "redirect:/hero-"+heroId+".htm";
		}
		return "additem";
	}
	@RequestMapping("/admin/deleteitem-{itemId}")
	public String removeItem(@PathVariable("itemId") Integer itemId)
	{
		Item item = itemDAO.findOne(itemId);
		int heroId = item.getHero().getId(); 
		itemDAO.delete(itemId);
		return "redirect:/hero-"+heroId+".htm";
		
	}
}
