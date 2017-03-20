/*
Document   : userAttemptQuiz
Created on : Feb 23, 2017, 10:20:40 AM
Author     : Atanas, Krasi Philipp
*/

function submitQuiz() {
  // scroll to answer section
  document.getElementById('submitButton').style.display = "none";
  for(var c = 0; c < document.getElementsByClassName('explanation').length; c++)
  document.getElementsByClassName('explanation')[c].style.display = "block";
  $('html, body').animate({
  scrollTop: $('.quiz-result').offset().top
  });
  //document.getElementById("demo3").innerHTML = "Reached.";
  quiz._showResult( quiz._calcResult() ); //BROKEN AS FUCK TODO
  $('.quiz-answer').off('click'); //BROKEN AS FUCK TOD 
}

function showDiv() 
{
  document.getElementById('showDiv').style.display = "block";
  document.getElementById('button').style.display = "none";
  document.getElementById('buttonSummary').style.display = "none";
  document.getElementById('buttonBack').style.display = "none";
}

function showSummary()
{
  document.getElementById('showSummaryDiv').style.display = "block";
  document.getElementById('buttonSummary').style.display = "none";
  document.getElementById('button').style.display = "none";

}

var Quiz = function(){
  var self = this;
  this.init = function(){
    self._bindEvents();
  }

var qT = document.getElementById('questionTotal'); // The number of questions in the quiz 5 .. 6 .. 7 ..
var qA = document.getElementById('questionAnswer'); // All the correct answers in the quiz acdbdacddef
var ansTotal = document.getElementById('questAnswers'); // One Question Answers Total Number Question 44445
var questCorrAns = document.getElementById('questCorrAnswers'); // One Question Number Of Correct Answers 21223
this.questAndAns = [];
var stored = "";
var stored2 = "";

var correctAnsString = "";

var iterator = 0;

for(i=0; i<qT.dataset.questionTotal; i++) 
{
  var sum = i+1;
  //stored += "Q:" + sum + " " + "A: " + qA.dataset.questionAnswer[i] + "; ";
  stored += " Q:" + sum + " A: " ;
  for(j=0; j< questCorrAns.dataset.questCorrAnswers[i]; j++) 
  {
    stored += qA.dataset.questionAnswer[iterator];
    correctAnsString += qA.dataset.questionAnswer[iterator];
    iterator = iterator+1;
  }
  stored2 += " Q:" + sum + " " + "NumAns:" + ansTotal.dataset.questAnswers[i] + "; ";
  this.questAndAns.push({question: i+1, answer: correctAnsString});
  correctAnsString = "";
}
//stored = questCorrAns.dataset.questCorrAnswers[iterator];

//document.getElementById("demo").innerHTML = stored;
//document.getElementById("demo2").innerHTML = stored2;
  /*this.questAndAns = [	
    { question: 1, answer: 'a' },
    { question: 2, answer: 'b' },
    { question: 3, answer: 'd' },
    ]*/
var collectScore = 0.00;
var maxScore = 0.00;

for(m = 0; m < questCorrAns.dataset.questCorrAnswers.length; m++)
{
  maxScore = maxScore + parseInt(questCorrAns.dataset.questCorrAnswers[m]);
}




//Adds and removes the css class for the selected answer
this._pickAnswer = function($answer, $answers){
    //$answers.find('.quiz-answer').removeClass('active');
    if($answer.hasClass('active'))$answer.removeClass('active');
    else  $answer.addClass('active');

    
  }
  this._calcResult = function(){
    var numberOfCorrectAnswers = 0.00;
    var numberOfWrongAnswers = 0.00;
    $('ul[data-quiz-question]').each(function(i)
    {
      //document.getElementById("demo3").innerHTML += " ||| ";
      var $this = $(this);
      var correctAnswers = [];
      var chosenAnswers =[];
      var activeAnswers = $( "li.quiz-answer.active" );
      //document.getElementById("demo3").innerHTML += "HIIII      ";
/*    
      for(w=0;w<activeAnswers.length;w++)
      {
        chosenAnswers[w] = activeAnswers[w];
      }

        document.getElementById("demo3").innerHTML += " \THIS SHIT " + chosenAnswers.data('quiz-answer').toString();

        document.getElementById("demo3").innerHTML += "    Active answer length:  " + $(this).find( activeAnswers ).length;
        */
        /*for(var w=0;w<$(this).find(".active").length;w++)
        {
          //document.getElementById("demo3").innerHTML += " w: " + w;
          //document.getElementById("demo3").innerHTML += " < " + $(this).find(".active").length;
         // document.getElementById("demo3").innerHTML += " \nActive Answers " + $(this).find(".active").data('quiz-answer')[w];
          //chosenAnswers.push($(this).find(activeAnswers[w]).data('quiz-answer').toString());
        }*/
        $($(this).find(".active")).each(function(j){
        //document.getElementById("demo3").innerHTML += " Q:" + j + " Correct Answer: " + $(this).data('quiz-answer').toString();
        chosenAnswers.push($(this).data('quiz-answer').toString());
      });
        //document.getElementById("demo3").innerHTML += "HIIII      ";
         var a = self.questAndAns[i];

        //if ( a.question == $this.data('quiz-question')) {
          for(var x = 0; x < a.answer.length; x++)
          {
            correctAnswers.push(a.answer[x]);  // collects correct answers for current question
          }
        //}
      //document.getElementById("demo3").innerHTML += "OUTPUT1: " + correctAnswers.length;
      var matchPosition = -1;
      var wrongAnswer = -1;
      for(var k = 0; k < chosenAnswers.length; k++)
      {
        //document.getElementById("demo3").innerHTML += correctAnswers.toString();
        for(var p = 0; p < correctAnswers.length; p++)
        {
          if ( chosenAnswers[k] == correctAnswers[p] ) 
          {
            matchPosition = k;
          } 
          else if ( chosenAnswers[k] != correctAnswers[p])
          {
            wrongAnswer = k;
          }
        }
        if(matchPosition != -1)
        {  
          
          // highlight this as correct answer
          //document.getElementById("demo3").innerHTML += "HIIII    5  ";
          $($(this).find(".active")).each(function(j)
          {
            if(j == matchPosition)
              {   
                //numberOfCorrectAnswers++;
                $(this).addClass('correct');
              }
          });
          //$(this).find(".active")[matchPosition].addClass('correct');
          //matchPosition = -1;
        }
        else 
        {
          
          //$this.find('.quiz-answer[data-quiz-answer="'+correctAnswers+'"]').addClass('correct');
          //$this.find('.quiz-answer.active').addClass('incorrect');
          //document.getElementById("demo3").innerHTML += "HIIII    4  ";
          $($(this).find(".active")).each(function(j)
          {
            if(j == wrongAnswer)
            {
              $(this).addClass('incorrect');
              //document.getElementById("demo3").innerHTML += " F Score: ";
              /*document.getElementById("demo3").innerHTML += "Q" + i + "A" + j + " ";
              numberOfWrongAnswers ++;
              if (numberOfWrongAnswers >= numberOfCorrectAnswers) 
                {
                  numberOfWrongAnswers = 0;
                  numberOfCorrectAnswers = 0;
                }
              else numberOfCorrectAnswers = numberOfCorrectAnswers - numberOfWrongAnswers;*/
            }

          });
          //$(this).find(".active")[k].addClass('incorrect');
          //matchPosition = -1;
        }
        matchPosition = -1;
        
        
      }
      // Mark not-selected correct answers green
      for(x = 0; x < correctAnswers.length; x++)
      {
        //$this.find('.quiz-answer[data-quiz-answer="'+ correctAnswers[x] +'"]')[x].addClass('correct');
        $( $(this).find(".quiz-answer") ).each(function(j)
        {
          if(correctAnswers[x] == $(this).data('quiz-answer').toString())$(this).addClass('correct');
        });
      }


      /*collectScore.push(numberOfCorrectAnswers - numberOfWrongAnswers);
      numberOfCorrectAnswers = 0;
      numberOfWrongAnswers = 0;*/
    });
    //Quiz Summary TODO

    $('ul[data-quiz-question]').each(function(i)
    {
      $($(this).find(".active")).each(function(j)
      {
        //document.getElementById("demo3").innerHTML += " Correct-Loop: " + "Q" + i + "A" + j;
        if($(this).hasClass('correct')) numberOfCorrectAnswers++;
        
      });
      //document.getElementById("demo3").innerHTML += " Correct: " + numberOfCorrectAnswers;

      $($(this).find(".active")).each(function(j)
      {
        //document.getElementById("demo3").innerHTML += " Wrong-Loop: " + "Q" + i + "A" + j;
        if($(this).hasClass('incorrect')) numberOfWrongAnswers++;
      });
      //document.getElementById("demo3").innerHTML += " Wrong: " + numberOfWrongAnswers;

      if(numberOfWrongAnswers >= numberOfCorrectAnswers)
      {
        numberOfCorrectAnswers = 0;
        numberOfWrongAnswers = 0;
      }
      else numberOfCorrectAnswers = numberOfCorrectAnswers - numberOfWrongAnswers;

      collectScore += numberOfCorrectAnswers;
      numberOfCorrectAnswers = 0;
      numberOfWrongAnswers = 0;

      //if(numberOfWrongAnswers >= numberOfCorrectAnswers) numberOfWrongAnswers = 0;
    });
    // SAVING SUMMARY DATA
    var str = "";
    $('ul[data-quiz-question]').each(function(i)
    {
      $($(this).find(".quiz-answer")).each(function(j)
      {
        if($(this).hasClass('active'))
        {
          str +=  j;
          
        }
      });
      $('#SavedQuestion'+i).val(str);
      str = "";
    });


    if ( Math.round((collectScore/maxScore)*100) < 40 ) {
      //document.getElementById("demo3").innerHTML += " Score: " + Math.round((collectScore/maxScore)*100) + "% / " + maxScore;// + "CS: " + collectScore.toString(); 
      //document.getElementById("scored").value=Math.round((collectScore/maxScore)*100);
      $("#scored").val(Math.round((collectScore/maxScore)*100));
      //if(document.getElementById("scored").value!=="")$( "#target" ).submit();
      return {code: 'bad', text: Math.round((collectScore/maxScore)*100) + "%"};
    }
    else if ( Math.round((collectScore/maxScore)*100) < 70 ) {
      //document.getElementById("demo3").innerHTML += " Score: " + Math.round((collectScore/maxScore)*100) + "% / " + maxScore;// + "CS: " + collectScore.toString();
     //document.getElementById("scored").value= Math.round((collectScore/maxScore)*100);
$("#scored").val(Math.round((collectScore/maxScore)*100));
      //if(document.getElementById("scored").value!=="")$( "#target" ).submit();
      return {code: 'mid', text: Math.round((collectScore/maxScore)*100) + "%"};
    }
    else if ( Math.round((collectScore/maxScore)*100) >= 70 ) {
      //document.getElementById("demo3").innerHTML += " Score: " + Math.round((collectScore/maxScore)*100) + "% / " + maxScore;// + "CS: " + collectScore.toString();
      //document.getElementById("scored").value =Math.round((collectScore/maxScore)*100);
      $("#scored").val(Math.round((collectScore/maxScore)*100));
      //if(document.getElementById("scored").value!=="")$( "#target" ).submit();
      return {code: 'good', text: Math.round((collectScore/maxScore)*100) + "%"};
    }
    else {
      return {code: 'debug', text: 'Debugging'};
    }
  }

//$( "#target" ).submit();
  //Calculates the score for a single question
 
   


  /*this._isComplete = function(){
    return true;
    var answersComplete = 0;
    $('ul[data-quiz-question]').each(function(){
      if ( $(this).find('.quiz-answer.active').length ) {
        answersComplete++;
      }
    });
    if ( answersComplete >= qT.dataset.questionTotal ) { //Get the number of questions
      return true;
    }
    else {
      return false;
    }
  }*/

  this._showResult = function(result){
    $('.quiz-result').addClass(result.code).html(result.text);
  }
  this._bindEvents = function(){
    $('.quiz-answer').on('click', function(){
      var $this = $(this),
      $answers = $this.closest('ul[data-quiz-question]');
      self._pickAnswer($this, $answers);
      /*if ( self._isComplete() ) {

        // scroll to answer section
        $('html, body').animate({
          scrollTop: $('.quiz-result').offset().top
        });
        
        self._showResult( self._calcResult() );
        $('.quiz-answer').off('click');
        
      }*/
    });
  }
}
var quiz = new Quiz();
quiz.init();

