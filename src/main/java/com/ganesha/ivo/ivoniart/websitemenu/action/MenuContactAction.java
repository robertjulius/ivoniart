package com.ganesha.ivo.ivoniart.websitemenu.action;

import com.ganesha.basicweb.utility.CommonUtils;
import com.ganesha.core.exception.AppException;
import com.ganesha.ivo.ivoniart.model.guessmessages.GuessMessage;
import com.ganesha.ivo.ivoniart.model.menucontact.MenuContact;
import com.ganesha.ivo.ivoniart.websitemenu.WebsiteMenuAction;

public class MenuContactAction extends WebsiteMenuAction {
	private static final long serialVersionUID = -2767499531394717306L;

	private MenuContact menuContact;
	private GuessMessage guessMessage;

	public MenuContactAction() throws AppException {
		menuContact = (MenuContact) getDBSession().createCriteria(
				MenuContact.class).uniqueResult();
	}

	public String getContent() {
		return menuContact.getContent();
	}

	public GuessMessage getGuessMessage() {
		return guessMessage;
	}

	public String getTitle() {
		return menuContact.getTitle();
	}

	public String saveGuessMessage() throws AppException {
		if (!guessMessage.getEmail().equals(guessMessage.getEmailConfirm())) {
			addFieldError("guessMessage.emailConfirm",
					"Email Confirm is different");
			return INPUT;
		} else {
			beginTransaction();

			guessMessage.setMessageDate(CommonUtils.getCurrentTimestamp());
			getDBSession().save(guessMessage);

			commit();

			addActionMessage("Your message has been sent successfully");
			guessMessage = null;

			return SUCCESS;
		}
	}

	public void setGuessMessage(GuessMessage guessMessage) {
		this.guessMessage = guessMessage;
	}
}
