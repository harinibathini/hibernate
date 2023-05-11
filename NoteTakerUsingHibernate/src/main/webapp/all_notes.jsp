<%@page import="entities.*"%>
<%@page import="org.hibernate.Query"%>
<%@page import="helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>All Notes: Note Taker</title>
    <%@include file="all_js_css.jsp"%>
  </head>

  <body>
  <div class = "container">
         <%@include file = "navbar.jsp" %>
         <br>
         <h1 class="text-uppercase">All Notes</h1>

         <div class="row">
         <div class="col-12"
          <%
          Session session1 = FactoryProvider.getSessionFactory().openSession();
                   Query q = session1.createQuery("from Note");
                   List<Note> list = q.list();
                   for(Note note:list){
                   %>
                   <div class="card mt-3 ">
                     <img class="card-img-top m-3 mx-auto" style="max-width:50px;" src="img/notes.png" alt="Card image cap">
                     <div class="card-body mx-auto">
                       <h5 class="card-title"><%= note.getTitle() %></h5>
                       <p class="card-text mx-auto">
                       <%= note.getContent() %>
                       </p>
                       <p ><b class="text-primary"><%= note.getAddedDate() %></b></p>
                       <div class="container text-center mt-2">
                       <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
                       <a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Update</a>
                     </div>
                   </div>
                   <!--  out.println(note.getId()+" : "+note.getTitle());  -->
                   <%
                   }
                   session1.close();
                   %>

         </div>



     </div>

  </body>
</html>