package com.ganesha.ivo.ivoniart.model.menueventandnews;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ganesha.ivo.ivoniart.model.BasicWebsiteMenu;
import com.ganesha.ivo.ivoniart.model.event.Event;
import com.ganesha.ivo.ivoniart.model.news.News;

@Entity
@Table(name = "ms_menu_event_news")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuEventAndNews extends BasicWebsiteMenu {

	private static final long serialVersionUID = -1218882314919256632L;

	@ManyToMany
	@JoinTable(name = "ms_event_list", joinColumns = @JoinColumn(name = "event_news_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> event;

	@ManyToMany
	@JoinTable(name = "ms_news_list", joinColumns = @JoinColumn(name = "event_news_id"), inverseJoinColumns = @JoinColumn(name = "news_id"))
	private List<News> newss;

	public List<Event> getEvent() {
		return event;
	}

	public List<News> getNewss() {
		return newss;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public void setNewss(List<News> newss) {
		this.newss = newss;
	}
}
