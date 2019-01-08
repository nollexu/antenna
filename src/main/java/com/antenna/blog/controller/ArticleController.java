package com.antenna.blog.controller;

import com.antenna.blog.entity.Article;
import com.antenna.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Api(description = "写作相关控制器")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/towrite")
    @ApiOperation(value = "跳转写作页面")
    public String toWrite() {
        return "write";
    }


    @GetMapping("/toUpdate/{articleName}")
    @ApiOperation(value = "跳转修改页面")
    public ModelAndView toUpdate(@PathVariable String articleName) {
        System.out.println("跳转修改页面");
        ModelAndView modelAndView=new ModelAndView();
        Article article = articleService.getArticleByName(articleName);
        modelAndView.addObject("article",article);
        System.out.println(article.id());
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping("/saveArticle")
    @ResponseBody
    @ApiOperation(value = "保存一篇文章")
    public String saveArticle(String articleContent, String articleName, String catagory, String wikiDescription) {
        Article article = new Article();
        article.articleContent(articleContent)
                .articleName(articleName)
                .catagory(catagory)
                .wikiDescription(wikiDescription)
                .createTime(LocalDateTime.now());
        articleService.saveArticle(article);
        return articleName;
    }

    @PostMapping("/updateArticle")
    @ResponseBody
    @ApiOperation(value = "更新一篇文章")
    public String updateArticle(Integer id,String articleContent, String articleName, String catagory, String wikiDescription) {
        Article article = new Article();
        article.articleContent(articleContent)
                .articleName(articleName)
                .catagory(catagory)
                .wikiDescription(wikiDescription)
                .updateTime(LocalDateTime.now())
                .id(id);
        System.out.println(article.id());
        articleService.updateArticle(article);
        return articleName;
    }

    @GetMapping("/listArticles")
    @ApiOperation(value = "查询所有文章")
    public ModelAndView listArticles(){
        ModelAndView modelAndView=new ModelAndView();
        List<Article> articles = articleService.listArticels();
        modelAndView.addObject("articles",articles);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/listArticlesManagement")
    @ApiOperation(value = "查询所有文章")
    public List<Article> listArticlesManagement(){
        List<Article> articles = articleService.listArticels();
        return articles;
    }

    @GetMapping("/showDetail/{articleName}")
    @ApiOperation(value = "从路径接收文章名，查看文章内容")
    public String showDetail(@PathVariable String articleName, Model model){
        System.out.println(articleName);
        Article article = articleService.getArticleByName(articleName);
        model.addAttribute("article",article);
        return "detail";
    }
}
