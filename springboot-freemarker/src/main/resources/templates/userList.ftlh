<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemark test</title>
</head>
<body>

<#noparse>
  demo:  <#include './header.ftlh'>
</#noparse>
<br>
<#include './header.ftlh'>

<table>
    <tr>
        <th>№</th>
        <th>ユーザー№</th>
        <th>ユーザー名</th>
        <th>備考</th>
    </tr>
    <#list userList as user>
        <tr>
            <td>${user.index}</td>
            <td>${user.userNo}</td>
            <td>${user.name}</td>
            <td>
                <#switch user.index>
                    <#case 1>一番<#break>
                    <#default>その他
                </#switch>
        </td>
        </tr>
    </#list>
</table>

<hr>

<#--<#escape x as x?html>-->
    ${content1}
    ${content2}
<#--</#escape>-->

</body>
</html>