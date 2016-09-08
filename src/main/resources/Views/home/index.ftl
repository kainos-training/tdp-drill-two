<#-- @ftlvariable name="" type="com.kainos.discoverydiary.views.BookListView" --> 
<#import "../layout.ftl" as layoutTemplate>  
<@layoutTemplate.layout>  

<script>

$(document).ready(function() {

$(".edit-btn").click(function() {

    var currentRow = $(this).closest('tr');

    var titleText = currentRow.find('.title-text');
    var titleEdit = currentRow.find('.title-edit');

    var authorText = currentRow.find('.author-text');
    var authorEdit = currentRow.find('.author-edit');

    titleEdit.val(titleText.text());
    authorEdit.val(authorText.text());

    titleText.hide();
    authorText.hide();

    titleEdit.show();
    authorEdit.show();

    var editBtn = currentRow.find('.edit-btn');
    editBtn.hide();

    var doneBtn = currentRow.find('.done-btn');
    doneBtn.show();

});


$(".done-btn").click(function() {
    var currentRow = $(this).closest('tr');

    var titleText = currentRow.find('.title-text');
    var titleEdit = currentRow.find('.title-edit');

    var authorText = currentRow.find('.author-text');
    var authorEdit = currentRow.find('.author-edit');

    titleText.text(titleEdit.val());
    authorText.text(authorEdit.val());

    titleText.show();
    authorText.show();

    titleEdit.hide();
    authorEdit.hide();

    var doneBtn = currentRow.find('.done-btn');
    doneBtn.hide();

    var editBtn = currentRow.find('.edit-btn');
    editBtn.show();

    var BookID = currentRow.find('.ID-edit');

    var PostData = {
        title: titleText.val(),
        author: authorText.val(),
        ID: BookID.val()
    };

    $.ajax({
      type: "POST",
      url: "/update",
      data: PostData
    });

});

});

</script>

<h1>Book list</h1>
 <p class="lead">Registered books.</p>  
<a class="btn btn-default" href="/add">Add Book</a>  
<table class="table"> 
<thead> 
    <th>Title</th> 
    <th>Author</th> 
    <th>Edit</th>
</thead>  
<tbody> 
    <#list books as book> 
<tr> 
<td> 
    <span class="title-text">${book.title} </span>
    <!-- This is the ID that is hidden -->
    <input type = "hidden" class = "ID-edit" value = "${book.ID}">
    <input type = "text" class = "title-edit" style="display:none">

</td> 
<td> 
    <span class="author-text">${book.author} </span>
    <input type = "text" class="author-edit" style="display:none">
</td> 
<td>
<button class="btn btn-default edit-btn"> Edit </button>  
<button class="btn btn-default done-btn" style="display:none"> Done </button>  
</td>
</tr> 
</#list>  
</tbody> 
</table>  

</@layoutTemplate.layout>
