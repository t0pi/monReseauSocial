-- Queries that'll be run at launch

INSERT INTO public.post(postdate, title, author,content) VALUES
(CURRENT_TIMESTAMP(), 'Aliquam dictum dui vel', '1', 'enean facilisis justo accumsan, et lorem elit ?');
INSERT INTO public.post(postdate, title, author,content) VALUES
(CURRENT_TIMESTAMP(), ' Sed pharetra', '2','Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc eget nulla sit amet ligula semper auctor. ');
INSERT INTO public.post(postdate, title, author,content) VALUES
(CURRENT_TIMESTAMP(), 'Duis a imperdiet libero', '2',  'Donec pellentesque, elit sit amet semper ornare, elit tortor molestie dui, commodo tincidunt turpis est id ligula. Fusce vitae ligula non lacus auctor finibus in id augue. Mauris lobortis libero sit amet nibh egestas, condimentum mattis orci iaculis. ');
INSERT INTO public.post(postdate, title, author,content) VALUES
(CURRENT_TIMESTAMP(), 'Lorem ipsum', '3',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque et lorem elit. Aliquam dictum dui vel sapien ultrices aliquet. Aenean facilisis justo accumsan semper dapibus. Curabitur id ex mollis, dictum leo ultrices.');

INSERT INTO public.user( name, pwd,mail)
VALUES ('Sylvanas Windrunner', '123','Nein@da.com');
INSERT INTO public.user( name, pwd,mail)
VALUES ('Arthas Menethil', '123','Nein@ya.com');
INSERT INTO public.user( name, pwd,mail)
VALUES ( 'Jaina Proudmoore', '123','Nein@fuck.com');
VALUES ( 'Illidan Stormrage', '123','Nein@oo.com');

SHOW TABLES;

INSERT INTO public.likes(post_id,author_id) VALUES ( 1,1);
INSERT INTO public.likes(post_id,author_id) VALUES ( 1,2);
INSERT INTO public.likes(post_id,author_id) VALUES ( 1,3);
INSERT INTO public.likes(post_id,author_id) VALUES ( 3,1);
INSERT INTO public.likes(post_id,author_id) VALUES ( 3,3);


INSERT INTO public.comment(date, author_id,content,post_id) VALUES
(CURRENT_TIMESTAMP(),1,'kek', 1);
INSERT INTO public.comment(date, author_id,content,post_id) VALUES
(CURRENT_TIMESTAMP(),3,'git gud', 1);

INSERT INTO public.comment(date, author_id,content,post_id) VALUES
(CURRENT_TIMESTAMP(),2,
'Aliquam mattis vestibulum neque in porta ! :DD', 4);

INSERT INTO public.comment(date, author_id,content,post_id) VALUES
(CURRENT_TIMESTAMP(),2,
'bien dit', 4);
