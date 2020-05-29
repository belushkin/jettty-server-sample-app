<html>

<body>
<table>

    <#list persons as person>
        <tr>
            <td>${person.name}</td>
            <td>${person.age}</td>
        </tr>
    </#list>
</table>
</body>


</html>
