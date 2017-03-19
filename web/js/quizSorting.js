$(".Sorting").change(function () {

    
    var text = [];
    var ids = [];
    var completed=[];
    
    if ($(this).val() === 'Ascending' || $(this).val() === 'Descending')
    {
        $('.grid-item').show();
        $('.grid-item').each(function (i) {
            text.push($(this).find('.name').val());
        });
        
        
        text.sort(function (a, b) {
            return a.toLowerCase().localeCompare(b.toLowerCase());
        });
        
        if($(this).val() === 'Descending')text.reverse();
        
        for (var j = 0; j < text.length; j++)
        {
            $('.grid-item').each(function (i) {
                if ($(this).find('.name').val() === text[j].toString())
                {
                    ids.push($(this).find('.quizID').val());
                    if($(this).find(".btnhandler").is(":visible"))
                    {
                        completed.push($(this).find('.quizID').val());
                        $(this).find(".btnhandler").css("display","none");
                    }
                    return false;
                }
            });
        }
        
        $('.grid-item').each(function (i) {
            $(this).find('.name').val(text[i]);
            $(this).find('.quizID').val(ids[i]);
            for(var s=0;s<completed.length;s++)
            {
                if(completed[s]===ids[i])
                {
                    $(this).find(".btnhandler").css("display","block");
                }
            }
        });
    }     
    else if ($(this).val() === 'Completed')
    {
        $('.grid-item').each(function () {
            var check = $(this).find(".btnhandler");
            if (!check.is(":visible"))
            {
                $(this).hide();
            }
        });
    }
    
    else if ($(this).val() === 'Nothing')
    {
        location.reload();
    }
});
