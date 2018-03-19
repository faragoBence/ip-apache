package com.codecool.lms.service;

import com.codecool.lms.exception.PageNotFoundException;
import com.codecool.lms.model.Page;

import java.util.ArrayList;
import java.util.List;

public class PageService {

    private List<Page> pages = new ArrayList<>();


    public List<Page> getPages() {
        return pages;
    }

    public void addNewPage(Page page) {
        pages.add(page);
    }

    public void removePage(String title) throws PageNotFoundException {
        pages.remove(findPageByTitle(title));
    }

    public Page findPageByTitle(String title) throws PageNotFoundException {
        for (Page page : pages) {
            if (page.getTitle().equals(title)) {
                return page;
            }
        }
        throw new PageNotFoundException();
    }
}
