package com.myjetty;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFreemarkerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration();
        cfg.setIncompatibleImprovements(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(MyFreemarkerServlet.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        Template template = cfg.getTemplate("personsHtmlPage.ftl");
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("msg", "Today is a beautiful day2");
        templateData.put("lang", "Java");


        List<Person> persons = initPersons(10);
        templateData.put("persons", persons);

        Writer out = resp.getWriter();
        try {
            template.process(templateData, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }


    private static List<Person> initPersons(int n){
        List<Person> persons = new ArrayList();
        for(int i=0;i<n;i++){
            persons.add(new Person("Name"+i, i));
        }
        return persons;
    }
}
