<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit a Quiz</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1>InstaGrim ! </h1>
        <h2>Your world in Black and White</h2>
        </header>
        <nav>
            <ul>

            </ul>
        </nav>
       
        <article>
            <h3>Submit a Quiz</h3>
            <form method="POST"  action="staffSubmitQuiz">
                <ul>
                    <%-- Quiz Information - taken once per quiz--%>
                    <li>Quiz Title: <input type="text" name="title" minlength="4" required="required"></li>
                    <li>ModuleId: <input type="text" name="moduleID" minlength="6" maxlength="10"  required ="required"></li>
                    <li>Availability: <input type="checkbox" name="available" value="1"> Yes </li>
                    <%-- Question Information--%>
                    <li>Number of questions to provide: <input type="number" name="questionsnumber" minlength="1" required="required"></li>

                    <%-- Display per number of questions to be given--%>
                    <li>Question Text: <input type="text" name="questiontext1" maxlength="1024"></li>
                    <li>Explanation Text: <input type="text" name="explanationtext1" maxlength="1024"></li>
                    <li>Valid: <input type="checkbox" name="valid1" value="1"> Yes</li>
                    <%-- --------------------------- --%>

                    <%-- Display per number of questions to be given TIMES FOUR--%>
                    <%-- Answer Information--%>
                    <li>Answer Text: <input type="text" name="answertext1" maxlength="255"></li>
                    <li>Correct: <input type="checkbox" name="correct1" value="1"> Yes</li>

                </ul>
                <br/>
                <input type="submit" value="staffSubmitQuiz"> 
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/">Home</a></li>
            </ul>
        </footer>
    </body>
</html>