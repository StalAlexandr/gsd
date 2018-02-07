INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (1, 100, 100, 100, 100, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (2, 100, 100, 100, 200, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (3, 100, 100, 100, 300, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (4, 100, 100, 100, 400, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (5, 100, 100, 100, 500, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (6, 100, 100, 300, 100, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (7, 100, 100, 300, 250, null);

INSERT INTO public.status(id, code, name, node_id) VALUES (1, '1', 'Заявка подана', 1);
INSERT INTO public.status(id, code, name, node_id) VALUES (2, '2', 'Формальная экспертиза', 1);
INSERT INTO public.status(id, code, name, node_id) VALUES (3, '3', 'Экспертиза по существу', 1);
INSERT INTO public.status(id, code, name, node_id) VALUES (4, '4', 'Готов выдать патент', 1);
INSERT INTO public.status(id, code, name, node_id) VALUES (5, '5', 'Патент выдан', 1);
INSERT INTO public.status(id, code, name, node_id) VALUES (6, '6', 'Заявка считается неподанной', 1);
INSERT INTO public.status(id, code, name, node_id) VALUES (7, '7', 'Запрос дополнительных материалов', 1);

UPDATE public.node set status_id = id;

INSERT INTO public.graph(id, from_id, to_id) VALUES (1, 1, 2);
INSERT INTO public.graph(id, from_id, to_id) VALUES (2, 2, 3);
INSERT INTO public.graph(id, from_id, to_id) VALUES (3, 3, 4);
INSERT INTO public.graph(id, from_id, to_id) VALUES (4, 4, 5);
INSERT INTO public.graph(id, from_id, to_id) VALUES (5, 1, 6);
INSERT INTO public.graph(id, from_id, to_id) VALUES (6, 6, 7);
INSERT INTO public.graph(id, from_id, to_id) VALUES (7, 3, 7);
INSERT INTO public.graph(id, from_id, to_id) VALUES (8, 7, 3);
INSERT INTO public.graph(id, from_id, to_id) VALUES (9, 4, 7);
INSERT INTO public.graph(id, from_id, to_id) VALUES (10, 7, 4);
