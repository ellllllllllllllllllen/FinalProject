package edu.epam.cafe.model.dao.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void findAll() {
        List<AboutUs> expected = new ArrayList<>();
        AboutUs aboutUs = new AboutUs();
        aboutUs.setId(1L);
        aboutUs.setMessage("Мы лучшая компания по изучению ИТ специалистов");
        expected.add(aboutUs);
        Mockito.when(aboutUsDao.findAll()).thenReturn(expected);
        List<AboutUs> actual = aboutUsService.findAll();
        Assert.assertEquals(actual, expected);
    }
}