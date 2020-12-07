/* Timelines could have been written in a better way, I am sorry if I wrote them in a hurry. :D */
var word;
var translation;
function getWord(){
	$.ajax({
        method : "POST",
        timeout : 5000,
        url : "http://localhost:8080/WordReview/search",
        data : 0,
        dataType : "json",
        contentType :'application/x-www-form-urlencoded; charset=UTF-8',
        async:false,
        success : function(data) {
         // 这里的数据是jsonArray
        	word = data.word;
        	translation = data.translation;
        },
        error : function() {
           alert("error");
        }
 	});  
	animation.animate();
}
var animation = {
    newWord: document.querySelector(".new-word"),
    range: function(min,max) {
      return Math.floor(Math.random() * (max - min + 1) + min);
    },
    
    get letterNumer() {
      // 得到单词长度
      var letterNumer = String(animation.Word).length;
      return letterNumer;
    },
    get Word(){
      // 设置单词
      return word;
    },
    element: function(parent, type, className, html) {
      var element = document.createElement(type);
      element.className = className;
      if (typeof html !== "undefined") element.innerHTML = html;
      parent.appendChild(element);
      return element;
    },
    word: function(className) {
      var word = animation.element(animation.newWord,'div',className);

      var timeline = new TimelineMax();
      // var year = animation.element(animation.newYear, "div", className);
      for (var i=0; i<=animation.letterNumer-1; i++) {
        var letter = animation.element(word, "div", "letter", String(animation.Word).substr(i, 1));
        letter.style.top = (0 - (letter.clientHeight * 2)) + "px";
        timeline
          .to(letter, 0.5, {top: 0, opacity: 1, ease: Bounce.easeOut});
      }
      return word;
    },
    animate: function() {
      var word1 = animation.word("word word1");
      var word2 = animation.word("word word2");
      var controls = animation.element(animation.newWord, "div", "controls");
      var translation = animation.element(controls, "div", "control translation");
      // var hours = animation.element(controls, "div", "control traslation");
      // var minutes = animation.element(controls, "div", "control minutes");
      // var seconds = animation.element(controls, "div", "control seconds");
      animation.controls = {
        controls: controls,
        translation: translation,
        // hours: hours,
        // minutes: minutes,
        // seconds: seconds
      };
      animation.render();
      var triangles = animation.element(word1, "div", "triangles");
      var fullTimeline = new TimelineMax();
      var triangleStorage = [];
      for (var i=0; i<=50-1; i++) {
        var timeline = new TimelineMax({repeat: -1});
        var triangle = animation.element(triangles, "div", "triangle");
        triangle.style.top = -50 + "px";
        var time = animation.range(0, 100) / 100;
        var duration = 1;
        var direction = animation.range(1, 2) == 1 ? -1 : 1;
        timeline
          .set(triangle, {scale: animation.range(10, 20) / 10}, time)
          .to(triangle, duration * 0.5, {opacity: 1}, time)
          .to(triangle, duration, {top: "200%", rotationZ: animation.range(180, 360) * direction, rotationX: animation.range(180, 360) * direction}, time)
          .to(triangle, duration * 0.5, {opacity: 0}, time + (duration * 0.5));
        fullTimeline.add(timeline, 0);
        triangleStorage.push(triangle);
      }
      var previousWidth = 0;
      var checkWidth = function() {
        if (Math.abs(previousWidth - word1.clientWidth) > 1) {
          for (var i=0; i<=triangleStorage.length-1; i++) {
            triangleStorage[i].style.left = (-5 + animation.range(0, word1.clientWidth)) + "px";
          }
          previousWidth = word1.clientWidth;
        }
        setTimeout(checkWidth, 100);
      }
      checkWidth();
      return new TimelineMax()
        .to(translation, 0.5, {top: 0, opacity: 1}, 0)
        // .to(hours, 0.5, {top: 0, opacity: 1}, 0.25)
        // .to(minutes, 0.5, {top: 0, opacity: 1}, 0.5)
        // .to(seconds, 0.5, {top: 0, opacity: 1}, 0.75)
        .set(triangles, {opacity: 1}, 3)
        .add(fullTimeline, 3);
    },
    get translation(){
      return 'meaning :'+translation;
    },
    render: function() {
      animation.controls.translation.innerHTML = animation.translation;
      // animation.controls.minutes.innerHTML = animation.plural("minutes");
      // animation.controls.hours.innerHTML = animation.plural("hours");
      // animation.controls.days.innerHTML = animation.plural("days");
      requestAnimationFrame(animation.render);
    }
  };
	getWord();
	$('.next').click(function(){
		$('.word').remove();
		$('.controls').remove();
		getWord();
	})
	function addWord(){
		var word = $('#word').val();
		var translation = $('#translation').val();
		alert(word);
		$.ajax({
	        method : "POST",
	        timeout : 5000,
	        url : "http://localhost:8080/WordReview/add",
	        data : {"word":word,"translation":translation},
	        dataType : "json",
	        contentType :'application/x-www-form-urlencoded; charset=UTF-8',
	        async:false,
	        success : function() {
	         // 这里的数据是jsonArray
	        },
	        error : function(e) {
	        	alert('添加成功!');
	        }
	 	});
	}
	$('.assure').click(function(){
		addWord();
	})
	