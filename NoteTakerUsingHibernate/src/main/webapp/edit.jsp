<%@page import="helper.*,org.hibernate.*,entities.*"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Edit/Update Notes</title>
    <%@include file="all_js_css.jsp"%>
  </head>

  <body>
  <div class = "container">
         <%@include file = "navbar.jsp" %>
         <br>
         <h1>This is edit page</h1>
         <%
         int noteId = Integer.parseInt(request.getParameter("note_id").trim());
         Session session3 = FactoryProvider.getSessionFactory().openSession();

         Note note = (Note)session3.get(Note.class, noteId);
         %>
         <form action="UpdateServlet" method="post">
         <input value="<%= note.getId() %>" name="noteId" type="hidden"/>
                    <div class="form-group">
                      <label for="title">Note title</label>
                      <input
                      name="title"
                      required
                      type="text"
                      class="form-control"
                      id="title"
                      aria-describedby="emailHelp"
                      placeholder="Enter here"
                      value="<%= note.getTitle() %>"/>
                    </div>
                    <div class="form-group">
                      <label for="content">Note Content</label>
                     <textarea name="content"
                     required
                     id="content"
                     placeholder="Enter your content here"
                       class="form-control"
                       style="height:150px;"
                       ><%= note.getContent()%></textarea>
                    </div>

                    <div class="container text-center">
                         <button type="submit" class="btn btn-success">Save your note</button>
                    </div>
                  </form>

     </div>

  </body>
</html>