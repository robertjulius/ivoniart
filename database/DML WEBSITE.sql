DELETE FROM ms_picture;
INSERT INTO ms_picture (id, create_by, create_date, rec_status, update_by, update_date, title, comment) VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'Empty Picture', 'This data just for initial picture only');

DELETE FROM ms_menu_about;
INSERT INTO ms_menu_about (id, create_by, create_date, rec_status, update_by, update_date, title, picture_id, content)
VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'About Me', '1', 'Initial content');

DELETE FROM ms_menu_contact;
INSERT INTO ms_menu_contact (id, create_by, create_date, rec_status, update_by, update_date, title, picture_id, content, address, email, phone)
VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'Contact', '1', 'Initial content', 'Jl. Alpukat V No 50', 'robertjulius09@gmail.com', '+6281908274126');

DELETE FROM ms_menu_services;
INSERT INTO ms_menu_services (id, create_by, create_date, rec_status, update_by, update_date, title, picture_id, content)
VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'Services', '1', 'Initial content');

DELETE FROM ms_menu_home;
INSERT INTO ms_menu_home (id, create_by, create_date, rec_status, update_by, update_date, quick_link1, quick_link2)
VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, 'This is the quick link 1', 'This is the quick link 2');

DELETE FROM ms_web_items;
INSERT INTO ms_web_items (id, create_by, create_date, rec_status, update_by, update_date, logo_img, copyright, bg_img)
VALUES ('1', 'SYSTEM', CURRENT_TIMESTAMP, 'A', 'SYSTEM', CURRENT_TIMESTAMP, '1', 'Copyright by Robert Julius', '1');
