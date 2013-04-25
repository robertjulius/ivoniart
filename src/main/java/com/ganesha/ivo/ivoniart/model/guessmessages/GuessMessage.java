package com.ganesha.ivo.ivoniart.model.guessmessages;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ganesha.basicweb.model.TableEntity;

@Entity
@Table(name = "lg_guess_message")
public class GuessMessage implements TableEntity {

	private static final long serialVersionUID = 2343345295596584661L;;

	@Id
	@Column(name = "message_date")
	private Timestamp messageDate;

	private String name;
	private String company;
	private String phone;
	private String email;

	@Column(length = 1024)
	private String messages;

	@Transient
	private String emailConfirm;

	public String getCompany() {
		return company;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailConfirm() {
		return emailConfirm;
	}

	public Timestamp getMessageDate() {
		return messageDate;
	}

	public String getMessages() {
		return messages;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public void setMessageDate(Timestamp messageDate) {
		this.messageDate = messageDate;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
