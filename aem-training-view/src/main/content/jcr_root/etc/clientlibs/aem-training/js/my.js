jQuery(function ($){

    $(".my-iframe-href").click(function(event){
        var target = this;
        var attributes = {};
            attributes.src = target.href;
            attributes.title = $(target).data("title") || 'Insert title';
        var size = $(target).data("size") || '300,300';
            size = size.split(',');
            attributes.width = size[0];
            attributes.height = size[1];
            attributes.style = $(this).position();
            attributes.sandbox = "allow-scripts";
        var STRUCTURE_TO_CREATE = '<div class="my-iframe-div">' +
                        '<img class="my-iframe-div-close-btn" src="/etc/designs/aem-training/img/b_close.png" alt="x">' +
                        '<h3>' + attributes.title + '</h3>' +
                        '<div class="my-iframe-div-content">' +
                            '<iframe src=' + attributes.src + ' width=' + attributes.width + ' height=' + attributes.height + ' sandbox=' + attributes.sandbox + ' frameborder="0" marginwidth="0" marginheight="0"/>' +
                        '</div>' +
                    '</div>';
        $(STRUCTURE_TO_CREATE).css(attributes.style).appendTo("body").fadeIn();
        $(".my-iframe-div-close-btn").unbind("click.myIframeCloseButton").bind("click.myIframeCloseButton", function(event){
            $(event.target).parent(".my-iframe-div").fadeOut(400, function(){
                this.remove();
            });
        });
        event.stopPropagation();
        event.preventDefault();
    })
});