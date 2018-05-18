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
            	       '		<form id = "clientDogPojo">' +
                       '                            <label class="col-sm-4 control-label">Dog Name</label>\n' +
                       '                            <div class="col-sm-8 controls">\n' +
                       '                                <input id="name-'+i+'" name="homeNumber" type="text" placeholder="Name"\n' +
                       '                                            class="input-xlarge"/>\n' +
                       '                            </div>\n' +
                       '                        </div>\n' +
                       '                    </br>\n' +
                       '                        <div class="control-group">\n' +
                       '                            <label class="col-sm-4 control-label">Dog breed</label>\n' +
                       '                            <div class="col-sm-8 controls">\n' +
                       '                            <input id="breed-'+i+'" name="dogBreed" type="text" placeholder="Dog breed"\n' +
                       '                                            class="input-xlarge"/>\n' +
                       '                                            </div>\n' +
                       '                        </div>\n' +
                       '                    </br>\n' +
                       '                           <div class="control-group">\n' +
                       '\t                            <label class="col-sm-4 control-label">Date of birth</label>\n' +
                       '\t                            <div class="col-sm-8 controls">\n' +
                       '\t                            <input id="dateOfBirth-'+i+'" type="date" path="dateOfBirth" />                             \n' +
                       '                            </div>\n' +
                       '                        </div>\n' +
                       ' 		</form>' +
                       '                    </div>\n' +
                       '                    </br>'
             
            );
        }

    }).change();

    $('#client-info-form').on('submit',function(event){
    	event.preventDefault();
    	var dogs = parseInt($(this).find('#noOfDogs').val());
    	var dogData = [];
    	for(i=0;i < dogs; i++){
    		var dogObj = {};
    		dogObj['name'] = $(this).find('#name-'+i+'').val();
    		dogObj['breed'] = $(this).find('#breed-'+i+'').val();
    		dogObj['dateOfBirth'] =$(this).find('#dateOfBirth-'+i+'').val();
    		dogObj['clientId'] = $(this).find('#id').val();
    		dogData.push(dogObj);
    	}
    	$.ajax({
            type: "POST",
            url: '/app/dogDetails',
            contentType: 'application/json',
            data: JSON.stringify(dogData),
            dataType : 'json',
            success: function(data){   
            	console.log("ajax data success : "+data);
                $(this).submit();
            },
            error: function(data){   
            	console.log("ajax data error: "+data);
                $('#client-info-form').attr('action',"/app/updateClient").off('submit').submit();
            }
    	});
    	return false;
    	
    });
});