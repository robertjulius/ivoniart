DELETE FROM ms_menu_about;
INSERT INTO ms_menu_about (id, create_by, create_date, rec_status, update_by, update_date, content, title, picture_id) VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'This paragraph is the content of menu about', 'About', '');

DELETE FROM ms_menu_services;
INSERT INTO ms_menu_services (id, create_by, create_date, rec_status, update_by, update_date, content, title, picture_id) VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'This paragraph is the content of menu services', 'Services', '');

DELETE FROM ms_menu_contact;
INSERT INTO ms_menu_contact (id, create_by, create_date, rec_status, update_by, update_date, address, content, email, phone, title) VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'Jl. Alpukat V No 50', 'You can contact us anytime', 'robertjulius09@gmail.com', '+6281908274126', 'Contact Us');