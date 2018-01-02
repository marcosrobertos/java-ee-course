package com.macrob.course.jee.jsf.controller;

import com.macrob.course.jee.jsf.model.BookExt;
import com.macrob.course.jee.jsf.model.CD;
import com.macrob.course.jee.jsf.model.Item;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@RequestScoped
public class ItemController {

  // ======================================
  // =             Attributes             =
  // ======================================

  private BookExt book = new BookExt();
  private CD cd = new CD();
  private Item item = new Item();
  private List<Item> itemList = new ArrayList<Item>();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    return null;
  }

  public String doCreateCD() {
    return null;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public BookExt getBook() {
    return book;
  }

  public void setBook(BookExt book) {
    this.book = book;
  }

  public CD getCd() {
    return cd;
  }

  public void setCd(CD cd) {
    this.cd = cd;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}