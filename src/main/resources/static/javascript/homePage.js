$(function(){ 

    $('.navHead').on('click',function(e){
        var name = e.target.parentElement.getAttribute('data-val');
        handleTab(e,name);
    });    

    function handleTab(evt,name){
        // Declare all variables
        var i, navcontent, navHead;

        // Get all elements with class="navContent" and hide them
        navcontent = document.getElementsByClassName("navContent");
        for (i = 0; i < navcontent.length; i++) {
            navcontent[i].style.display = "none";
        }

        // Get all elements with class="navHead" and remove the class "active"
        navHead = document.getElementsByClassName("navHead");
        for (i = 0; i < navHead.length; i++) {
            navHead[i].className = navHead[i].className.replace("active", "");
        }

        // Show the current tab, and add an "active" class to the button that opened the tab
        document.getElementById(name).style.display = "block";
        evt.currentTarget.className += " active";
    }
    
    $('#noOfDogs').change(function(evt){
    	$('#dog-info-container').empty();        
        var number = $(this).val();
        for(i = 0; i< number; i++){
            $("#dog-info-container").append(
            	       '    <div class="control-group">\n' +
                       '                            <label class="col-sm-4 control-label">Dog Name</label>\n' +
                       '                            <div class="col-sm-8 controls">\n' +
                       '                                <input id="dogname-'+i+'" name="homeNumber" type="text" placeholder="Name"\n' +
                       '                                            class="input-xlarge"/>\n' +
                       '                            </div>\n' +
                       '                        </div>\n' +
                       '                    </br>\n' +
                       '                        <div class="control-group">\n' +
                       '                            <label class="col-sm-4 control-label">Dog breed</label>\n' +
                       '                            <div class="col-sm-8 controls">\n' +
                       '                            <input id="dogbreed-'+i+'" name="dogBreed" type="text" placeholder="Dog breed"\n' +
                       '                                            class="input-xlarge"/>\n' +
                       '                                            </div>\n' +
                       '                        </div>\n' +
                       '                    </br>\n' +
                       '                           <div class="control-group">\n' +
                       '\t                            <label class="col-sm-4 control-label">Date of birth</label>\n' +
                       '\t                            <div class="col-sm-8 controls">\n' +
                       '\t                            <input id="dogdob-'+i+'" type="date" path="dateofbirth" />                             \n' +
                       '                            </div>\n' +
                       '                        </div>\n' +
                       '                    </div>\n' +
                       '                    </br>'
             
            );
        }

    }).change();

    $('#client-info-form').on('submit',function(event){
    	var dogs = parseInt($(this).find('#noOfDogs').val());
    	var dogData = [];
    	for(i=0;i < dogs; i++){
    		var dogObj = {};
    		dogObj['dogName'] = $(this).find('#dogname-'+i+'').val();
    		dogObj['dogBreed'] = $(this).find('#dogbreed-'+i+'').val();
    		dogObj['dogdob'] =$(this).find('#dogdob-'+i+'').val();
    		dogData.push(dogObj);
    	}
    	$.ajax({
            type: "POST",
            url: '/sendDogInfo',
            contentType: 'application/json',
            data: dogData
    	});    
    });
});