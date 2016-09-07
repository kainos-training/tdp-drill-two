<#-- @ftlvariable name="" type="com.kainos.discoverydiary.views.PeopleListView" --> 
<#import "../layout.ftl" as layoutTemplate>  
<@layoutTemplate.layout>  
<h1>Book list</h1>
 <p class="lead">Registered books.</p>  
<table class="table"> 
<thead> 
<th>Title</th> 
<th>Author</th> 
</thead>  
<tbody> 
<#list books as book> 
<tr> 
<td> 
${book.Title} 
</td> 
<td> 
${book.Author} 
</td> 
</tr> 
</#list>  
</tbody> 
</table>  
<a class="btn btn-default" href="/book/add">Add Book</a>  
</@layoutTemplate.layout>
