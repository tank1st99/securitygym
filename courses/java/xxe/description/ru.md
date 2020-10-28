## Атака "XML External Entity (XXE)"

**XML External Entity (XXE)** - это тип атаки на приложение, обрабатывающее XML. Атака возможна, когда XML-парсер сконфигурирован с поддержкой внешних XML-сущностей.
XXE может привести к раскрытию конфиденциальной информации, отказу в обслуживании сервиса, SSRF (server side request forgery) и другим проблемам безопасности.

Перед использование XML-парсера для недоверенных данных:
- проверьте возможность подключения ```DTD-схем``` или ```External Entities```;
- если данная возможность включена, **явно выключите её**;
- обратите внимание на аналогичные риски при работе с документами в rich-форматах (DOCX, XLSX, PPTX и другие).

В таблице приведены атаки, к которым уязвимы XML-парсеры в конфигурации "по-умолчанию".

| Парсер      | DOS      | XXE     | XXE Parameter | URL Invocation | XInclude | XSLT |
|-------------|----------|---------|---------------|----------------|----------|------|
| Xerces SAX  | **yes**  | **yes** | **yes**       | **yes**        | no       | no   |
| Xerces DOM  | **yes**  | **yes** | **yes**       | **yes**        | no       | no   |
| w3cdocument | **yes**  | **yes** | **yes**       | **yes**        | no       | no   |
| JDOM        | **yes**  | **yes** | **yes**       | **yes**        | no       | no   |
| dom4j       | **yes**  | **yes** | **yes**       | **yes**        | no       | no   |
| minidom     | **yes**  | **yes** | **yes**       | **yes**        | no       | no   |

## Защитные меры

* Для SAX парсера
    ```java
    parser.setFeature("http://xml.org/sax/features/external-general-entities", false);
    parser.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    parser.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    documentBuilder.setEntityResolver(new XMLHanlder())
    ```
    где ваш XMLHandler должен возвращать пустую строку(**не NULL**)
* Для jDOM парсера
    ```java
    builder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    ```
* Для JAXB парсера
    ```java
    JAXBContext jc = JAXBContext.newInstance(Customer.class);
    XMLInputFactory xif = XMLInputFactory.newFactory();
    xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
    xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
    XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource("src/xxe/input.xml"));

    Unmarshaller unmarshaller = jc.createUnmarshaller();
    Customer customer = (Customer) unmarshaller.unmarshal(xsr);

    Marshaller marshaller = jc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(customer, System.out);
    ```

### Задание

Приведенный код, обработки счетов в XML-формате, уязвим к атаке XXE. Исправь уязвимость, не меняя поведение программы.

### Дополнительная информация

* https://www.owasp.org/index.php/XML_External_Entity_%28XXE%29_Processing