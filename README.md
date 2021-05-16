# OOTPiSP/ООТПиСП/Объектно-ориентированные технологии программирования и стандарты проектирования

### Лабораторные работы ПОИТ/БГУИР

#### Первая

"Ознакомление с концепциями ООП: наследование и полиморфизм типов (виртуальные методы)" 
Построить иерархию классов для вывода графических фигур: отрезок, прямоугольник, эллипс и т.д - не менее 6 классов в иерархии.
Распределить классы по модулям. Создать список фигур в виде отдельного класса. В главном модуле программы добавить в список различные фигуры (статическая инициализация), после чего запустить рисование списка фигур. Выполнить задание на языке C++, C# или Java.
Для рисования использовать любую подходящую графическую библиотеку. Если изучение графической библиотеки вызывает затруднение, допускается вывод фигур в файл или на экран в виде текстовых строк вида "Rectangle(10, 20, 30, 40)".

#### Вторая (OOP_3)

"Графический редактор"
Расширить пример с графическими фигурами так, чтобы фигуры можно было создавать на уровне пользовательского интерфейса.
Существуют несколько способов: ввод координат с помощью мыши, диалоговый ввод значений, ввод на скриптовом языке.
Студент может выбрать любой способ ввода. Создание объекта должно выполняться так, чтобы добавление нового класса в систему не требовало изменения существующего кода 
(выбор типа с помощью оператора case/switch делать нельзя). Получившаяся программа должна представлять собой примитивный графический редактор.

#### Третья (OOP_3)

Построить иерархию классов по заданной теме
Варианты тем (либо придуманная студентом и одобренная препоадавателем): автопарк с различными типами движущихся средств; ювелирные украшения состоящие из разных материалов, камней, вкраплений и прочего; иерархическая структура работников с различными обязанностями; какие-то блюда из различных составляющих/ингредиентов, -- в общем темы, 
на основе которых можно разработать иерархию классов, использовать шаблоны). 
Иерархия классов должна иметь минимум 3 уровня наследования и минимум 5 отличающихся между собой классов, сущности которых можно создать. 
Структура по крайней мере одного класса должна содержать аггрегацию (когда в качестве поля или свойства класса выступает так же объект класса). 
Так же должен быть покрайней мере один список объектов, который можно изменять с помощью пользовательского интерфейса: добавлять, удалять 
элементы списка, редактировать выбранный элемент.
Реализовать все виды сериализации/десереализации списка созданных объектов в файл/из файла: бинарная, xml (yml), в произвольном текстовом формате. 
Реализовать возможность изменять значения свойств объектов (с помощью графического интерфейса. Должна быть возможность изменять значения свойств минимум 5 классов). 

#### Четвёртая (OOP_4)

На базе предыдущей лабораторной на основе плагинов(2-3 плагина) реализовать возможность обработки структур перед сохранением в файл.
В зависимости от варианта выбрать вид обработки: 
- шифрования/дешифрование разными алгоритмами
- архивация данных перед сохранением(сделал компрессию)
Тип обработки(например, конкретный алгоритм шифрования или архивации) выбрать из списка, который зависит от загруженных плагинов.
Загрузка плагинов производится автоматически из папки, либо выбором файла с плагином через пользовательский интерфейс.

#### Пятая (OOP_4)

В предыдущей лабораторной применить шаблоны проектирования.
У меня:
- стратегия
- одиночка
- декоратор
