<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>Add a person</h1>
<p class="lead">Please provide details of the person.</p>

<form enctype="multipart/form-data" action="/people/add" method="post" autocomplete="off">

    <#if errors??>
        <div class="bg-danger text-danger">
            <ul>
            <#list errors as error>
                <li>
                    ${error}
                </li>
            </#list>
            </ul>
        </div>
    </#if>


    <div class="form-group">
        <label for="name">Full name</label>
        <input name="name" type="text" placeholder="name" class="form-control" required />
        <p class="help-block">Don't worry about your middle name</p>
    </div>

    <div class="form-group">
        <label for="age">Age</label>
        <input name="age" type="number" placeholder="age" class="form-control" required />
    </div>

    <input type="submit" value="Confirm" class="btn btn-primary" />
    <a class="btn btn-default" href="/people">Cancel</a>

</form>


</@layoutTemplate.layout>