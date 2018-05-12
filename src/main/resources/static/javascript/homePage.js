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

});