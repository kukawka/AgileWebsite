/*
Document   : userAttemptQuiz
Created on : Feb 23, 2017, 10:20:40 AM
Author     : Atanas, Krasi Philipp
*/

function submitQuiz() {
  // scroll to answer section
  document.getElementById('submitButton').style.display = "none";
  $('html, body').animate({
  scrollTop: $('.quiz-result').offset().top
  });
  document.getElementById("demo3").innerHTML = "Reached.";
  quiz._showResult( quiz._calcResult() ); //BROKEN AS FUCK TODO
  $('.quiz-answer').off('click'); //BROKEN AS FUCK TOD 
}

function showDiv() 
{
  document.getElementById('showDiv').style.display = "block";
  document.getElementById('button').style.display = "none";
  document.getElementById('buttonSummary').style.display = "none";
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

document.getElementById("demo").innerHTML = stored;
document.getElementById("demo2").innerHTML = stored2;
  /*this.questAndAns = [	
    { question: 1, answer: 'a' },
    { question: 2, answer: 'b' },
    { question: 3, answer: 'd' },
    ]*/



//Adds and removes the css class for the selected answer
this._pickAnswer = function($answer, $answers){
    //$answers.find('.quiz-answer').removeClass('active');
    if($answer.hasClass('active'))$answer.removeClass('active');
    else  $answer.addClass('active');

    
  }
  this._calcResult = function(){
    var numberOfCorrectAnswers = 0;
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
        document.getElementById("demo3").innerHTML += " Q:" + j + " Correct Answer: " + $(this).data('quiz-answer').toString();
        chosenAnswers.push($(this).data('quiz-answer').toString());
      });
        //document.getElementById("demo3").innerHTML += "HIIII      ";
         var a = self.questAndAns[i];

        //if ( a.question == $this.data('quiz-question')) {
          for(var x = 0; x < a.answer.length; x++)
          {
            correctAnswers.push(a.answer[x]);
          }
        //}
      //document.getElementById("demo3").innerHTML += "OUTPUT1: " + correctAnswers.length;
      var matchPosition = -1;
      for(var k = 0; k < chosenAnswers.length; k++)
      {
        //document.getElementById("demo3").innerHTML += correctAnswers.toString();
        for(var p = 0; p < correctAnswers.length; p++)
        {
          if ( chosenAnswers[k] == correctAnswers[p] ) 
          {
            matchPosition = k;
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
                document.getElementById("demo3").innerHTML += " T Score: ";                
                var storeScore = numberOfCorrectAnswers;
                var qMaxScore = questCorrAns[j]; //Maximum score for current question 21223
                var qScore = qMaxScore + score;
                if (qScore < 0) qScore = 0;
                else if (qScore > qMaxScore) qScore = qMaxScore;
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
            if(j == k)$(this).addClass('incorrect');
            document.getElementById("demo3").innerHTML += " F Score: ";
            numberOfCorrectAnswers --;
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
    });
    //Quiz Summary TODO

    if ( numberOfCorrectAnswers < qT.dataset.questionTotal/3 ) {
      return {code: 'bad', text: 'Bad'};
    }
    else if ( numberOfCorrectAnswers < qT.dataset.questionTotal/2 ) {
      return {code: 'mid', text: 'Moderate'};
    }
    else if ( numberOfCorrectAnswers >= qT.dataset.questionTotal/1.5 ) {
      return {code: 'good', text: 'Excellent'};
    }
    else {
      return {code: 'debug', text: 'Debugging'};
    }
  }

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

