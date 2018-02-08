INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (1, 100, 100, 10, 100, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (2, 100, 100, 10, 200, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (3, 100, 100, 10, 300, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (4, 100, 100, 10, 400, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (5, 100, 100, 10, 500, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (6, 100, 100, 210, 100, null);
INSERT INTO public.node(id, height, width, xposition, yposition, status_id) VALUES (7, 100, 100, 210, 250, null);

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
INSERT INTO public.graph(id, from_id, to_id) VALUES (6, 7, 6);
INSERT INTO public.graph(id, from_id, to_id) VALUES (7, 3, 7);
INSERT INTO public.graph(id, from_id, to_id) VALUES (8, 7, 2);


INSERT INTO public.operation( id, code, name) VALUES (1, 1, 'Начать экспертизу');
INSERT INTO public.operation( id, code, name) VALUES (2, 2, 'Закончить ФЭ');
INSERT INTO public.operation( id, code, name) VALUES (3, 3, 'Закончить ЭС');
INSERT INTO public.operation( id, code, name) VALUES (4, 4, 'Выдать патент');
INSERT INTO public.operation( id, code, name) VALUES (5, 5, 'Отклонить заявку');
INSERT INTO public.operation( id, code, name) VALUES (6, 6, 'Запросить доп. мат');
INSERT INTO public.operation( id, code, name) VALUES (7, 7, 'Продолжить рассмотрение');

INSERT INTO public.document(id, code, name) VALUES (1, 1, 'Пошлина за рассмотрение');
INSERT INTO public.document(id, code, name) VALUES (2, 2, 'Нотариальный перевод');
INSERT INTO public.document(id, code, name) VALUES (3, 3, 'Реферат');
INSERT INTO public.document(id, code, name) VALUES (4, 4, 'Формула изобетения');
INSERT INTO public.document(id, code, name) VALUES (5, 5, 'Пошлина за экспертизу');
INSERT INTO public.document(id, code, name) VALUES (6, 6, 'Пошлина за выдачу');
INSERT INTO public.document(id, code, name) VALUES (7, 7, 'Пошлина за продление');

INSERT INTO public.letter(id, code, name) VALUES (1, 1, 'О получении заявки');
INSERT INTO public.letter(id, code, name) VALUES (2, 2, 'О запросе материалов');
INSERT INTO public.letter(id, code, name) VALUES (3, 3, 'Об отказе в выдаче');
INSERT INTO public.letter(id, code, name) VALUES (4, 4, 'О завершении экспертизы');
INSERT INTO public.letter(id, code, name) VALUES (5, 5, 'О начале экспертизы');
INSERT INTO public.letter(id, code, name) VALUES (6, 6, 'О готовности выдать патент');
INSERT INTO public.letter(id, code, name) VALUES (7, 7, 'Патентная грамота');

INSERT INTO public.application(id, extidappli, title, status_id) VALUES (1, '111', 'Вечный двигатель', 1);
INSERT INTO public.application(id, extidappli, title, status_id) VALUES (2, '222', 'Гравицапа', 7);


update public.graph set operation_id=1 where id=1;
update public.graph set operation_id=2 where id=2;
update public.graph set operation_id=3 where id=3;
update public.graph set operation_id=4 where id=4;
update public.graph set operation_id=5 where id=5;
update public.graph set operation_id=5 where id=6;
update public.graph set operation_id=6 where id=7;
update public.graph set operation_id=1 where id=8;

INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (1, 1, 1);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (2, 2, 1);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (3, 3, 1);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (4, 4, 2);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (5, 5, 3);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (6, 6, 4);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (7, 7, 4);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (8, 4, 5);
INSERT INTO public.operation2document(id, document_id, operation_id) VALUES (9, 5, 6);

INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (1, 1, 1);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (2, 2, 6);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (3, 6, 4);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (4, 7, 4);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (5, 4, 2);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (6, 5, 1);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (7, 5, 3);
INSERT INTO public.operation2letter(id, letter_id, operation_id) VALUES (8, 2, 7);
