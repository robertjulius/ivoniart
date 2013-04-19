package com.ganesha.ivo.ivoniart.model.menueventandnews;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ganesha.basicweb.model.Trackable;
import com.ganesha.ivo.ivoniart.model.event.Event;
import com.ganesha.ivo.ivoniart.model.news.News;

@Entity
@Table(name = "ms_menu_event_news")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class MenuEventAndNews extends Trackable {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String title;
	private String content;

	@ManyToMany
	@JoinTable(name = "ms_event_list", joinColumns = @JoinColumn(name = "event_news_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> event;

	@ManyToMany
	@JoinTable(name = "ms_news_list", joinColumns = @JoinColumn(name = "event_news_id"), inverseJoinColumns = @JoinColumn(name = "news_id"))
	private List<News> newss;

	public String getContent() {
		return content;
	}

	public List<Event> getEvent() {
		return event;
	}

	public String getId() {
		return id;
	}

	public List<News> getNewss() {
		return newss;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNewss(List<News> newss) {
		this.newss = newss;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
