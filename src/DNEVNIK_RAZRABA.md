?? Дневник разработчика?? 24.03
шел второй день разрвботки приложения, отлично работает метод getAll, но такой же getId не работает исправно, вот что
пишет StackTrace
java.lang.ClassCastException: class com.example.thisismyproject.model.Apartment cannot be cast to class
com.example.thisismyproject.model.Apartment
самое прикольное, что каста никакого и нет, сам стек пишет, что кастится от обьекта одинаковвх классов)
подразумеваю что проблема в самом методе getID
буду смотреть
забегая вперед скажу, что че там происходит с классом RentApartment - вообще молчу )) они одинаковы вместе с APartment,
а стек у них абсолютно разный

java.lang.ClassCastException: class com.example.thisismyproject.model.RentApartment cannot be cast to class
com.example.thisismyproject.model.RentApartment (com.example.thisismyproject.model.RentApartment is in unnamed module of
loader 'app'; com.example.thisismyproject.model.RentApartment is in unnamed module of loader
org.springframework.boot.devtools.restart.classloader.RestartClassLoader @7a13e849)
at com.example.thisismyproject.service.impl.RentApartmentsDAOImpl.getRentApartmentById(RentApartmentsDAOImpl.java:
30) ~[classes/:na]

Вот такой стек)) оч странный
НО!
слава богу что теперь обе ENTITY или оба POJO класса подсоеденены к БД одинаково )0
что за хрень мне пишет стек - пока ума не приложу

Дима бизин подсказал, что нужно удалить sprindboot.dev.tools и вместе с ним папку target, и все заработало !!!!
небольшая запара будет с таблицей POSTGRESQL, по скольку id не хочет вставать BIGSERIAL-самообновляемый тип

я конечно очень не люблю костыли, но видимо у меня будет стоять поле id последним, хотя сча глянем

id | metro | minutes | style | comment | price | nature | rooms | meters | type_building | side | comments
----+--------+---------+--------+---------+-------+--------+-------+--------+---------------+--------+----------
2 | string | 0 | string | string | 0 | 0 | 0 | 0 | string | string | string
(1 row)
data_type
-------------------
bigint
character varying
smallint
character varying
character varying
bigint
double precision
smallint
smallint
character varying
character varying
character varying
(12 rows)

CREATE TABLE apartment(
id BIGSERIAL NOT NULL PRIMARY KEY,
metro VARCHAR(20) NOT NULL,
minutes SMALLINT NOT NULL,
style VARCHAR(20) NOT NULL,
comment VARCHAR(20) NOT NULL,
price BIGINT NOT NULL,
nature DECIMAL NOT NULL,
rooms SMALLINT NOT NULL,
meters SMALLINT NOT NULL,
type_building VARCHAR(20) NOT NULL,
side VARCHAR(20) NOT NULL,
comments VARCHAR(120) NOT NULL);

получилось с помощью запроса в БД
SELECT column_name, data_type FROM information_schema.columns
WHERE table_schema = 'public' AND table_name = TABLE_NAME

Отлично, при создании нового объекта возвращается правильный id этого объекта
дальше работа с enum...
И описания к контроллерам

Чем больше я пишу свое приложение, тем больше узнаю
оказалось что функции сервисов и аннотаций будут выполнятся лишь тогда, когда ты действуешь по правилам Spring!

нужно сделать так чтобы каждый созданный файл имел одинаковую информацию, либо 
чтобы файл создавался одного типа с информацией, а после импортировался в любом удобном формате!!!!!

хочу сделать ветку этого коммита с hubernate, после перейти на репозиторий!
создать геттер ссылки на определенное обьявление под определенным айди
реализовать выборку квартир по определенным(заданным) параметрам, например, в формате json!

создать получение всех типов данных в таблице и использовать после Spring Sec 

решил немного сузить кругозор приложения, если что потом добавлю этот функционал
загрузка и выгруза yaml, txt файлов!1