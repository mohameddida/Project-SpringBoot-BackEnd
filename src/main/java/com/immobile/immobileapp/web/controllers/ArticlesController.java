package com.immobile.immobileapp.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.services.ArticlesServices;
import com.immobile.immobileapp.web.models.requests.ArticleForm;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
  @Autowired
  ArticlesServices articlesServices;

  // Create
  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("ArticleForm", new ArticleForm());
    return "create";
  }

  @PostMapping("/create")
  public String createArticle(@ModelAttribute("ArticleForm") @Valid ArticleForm articleForm,
      BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("article", articlesServices.getAllArticles());
      return "article/create";

    }

    // Create a new product object from the request body
    Article article = new Article();
    article.setPrice(articleForm.getPrice());
    article.setEmplacement(articleForm.getEmplacement());
    article.setDescription(articleForm.getDescription());
    article.setImageMain(articleForm.getImageMain());
    article.setImageOne(articleForm.getImageOne());
    article.setImageTwo(articleForm.getImageTwo());
    article.setImageThree(articleForm.getImageThree());
    article.setNbrPiece(articleForm.getNbrPiece());
    article.setDisponible(articleForm.getDisponible());

    return "redirect:/articles";
  }

  // Read
  @GetMapping
  public String showArticleList(Model model) {
    model.addAttribute("Articles", this.articlesServices.getAllArticles());
    return "list";
  }

  // Update
  @GetMapping("/{id}/edit")
  public String showEditForm(@PathVariable("id") Long id, Model model) {
    Optional<Article> article = articlesServices.getArticle(id);
    if (article == null) {
      return "edit";
    }

    ArticleForm articleForm = new ArticleForm(article.get().getId(), article.get().getEmplacement(),
        article.get().getDescription(),
        article.get().getPrice(), article.get().getNbrPiece(), article.get().getDisponible(),
        article.get().getImageMain(), article.get().getImageOne(), article.get().getImageTwo(),
        article.get().getImageThree());
    model.addAttribute("articleForm", articleForm);
    return "edit";
  }

  @PostMapping("/{id}/edit")
  public String updateArticle(@PathVariable("id") Long id,
      @ModelAttribute("articleForm") @Valid ArticleForm articleForm,
      BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("disponible", articlesServices.getAllArticles());
      return "edit";

    }
    Optional<Article> article = articlesServices.getArticle(id);

    if (article.isPresent()) {
      article.get().setDescription(articleForm.getDescription());
      article.get().setDisponible(articleForm.getDisponible());
      article.get().setNbrPiece(articleForm.getNbrPiece());
      article.get().setPrice(articleForm.getPrice());
      article.get().setEmplacement(articleForm.getEmplacement());
      article.get().setImageMain(articleForm.getImageMain());
      article.get().setImageOne(articleForm.getImageOne());
      article.get().setImageTwo(articleForm.getImageTwo());
      article.get().setImageThree(articleForm.getImageThree());
      articlesServices.updateArticle(article.get());
    } else {
      // Handle product not found
    }

    return "redirect:/products";
  }

  // Delete
  @PostMapping("/{id}/delete")
  public String deleteArticle(@PathVariable("id") Long id) {
    Optional<Article> article = articlesServices.getArticle(id);
    if (!article.isPresent()) {
      // Handle product not found
    }
    this.articlesServices.deleteArticle(id);
    return "redirect:/articles";
  }

}
