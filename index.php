<?php
session_start();
error_reporting(0);
include('includes/dbconnection.php');
?>

<!DOCTYPE html>
<html>
<head>
<title>Food Traceability System | Home Page</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,700italic,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<!--webfont-->
<!--js-->
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
		</script>
<!---- start-smoth-scrolling---->
</head>

<body>
		<div id="preloader">
			<br><br><br><h1> Welcome! </h1>
		</div>

		<style>
			
			#preloader{
				background: #000 url(images/loader.gif) no-repeat center center;
				background-size: 20%;
				height: 100vh;
				width: 100%;
				position: fixed;
				z-index: 100;
				text-align: center;
				color: white;
				font-family: "Courier New", monospace;
				
			}


		</style>

<?php include_once("includes/header.php");?>
<!-- banner -->
<div class="banner">
	<div class="container">
		<!-- responsiveslides -->
								<script src="js/responsiveslides.min.js"></script>
									<script>
										// You can also use "$(window).load(function() {"
										$(function () {
										 // Slideshow 4
										$("#slider3").responsiveSlides({
											auto: true,
											pager: false,
											nav: false,
											speed: 500,
											namespace: "callbacks",
											before: function () {
										$('.events').append("<li>before event fired.</li>");
										},
										after: function () {
											$('.events').append("<li>after event fired.</li>");
											}
											});
											});
									</script>
		<!-- responsiveslides -->
		<div  id="top" class="callbacks_container">
				<ul class="rslides" id="slider3">
					<li>
						<div class="banner-info">
							<h3>WE NEED YOUR SUPPORT</h3>
							<p>
								More than 750 million people suffer from hunger worldwide, the vast majority in developing countries. 
								This number is expected to go up by over 100 million after 2020 alone due to COVID-19. 
								Hunger and malnutrition are barriers to sustainable development as hungry people are less productive, and more prone to disease.​
								Hands need to be joined to end hunger, achieve food security and improved nutrition and promote sustainable agriculture
							</p>
							<a href="about.php" class="hvr-rectangle-out button">READ MORE</a>
						</div>
						<div class="clearfix"></div>
					</li>
					<li>
						<div class="banner-info">
							<h3>HELP TURN TEARS TO SURES</h3>
							<p>
								Zero Hunger is the second sustainable goal of the United Nations among 17 others. 
								The United Nations strives to nourish today’s 750 million hungry people and the additional 2 billion people expected by 2050.​
								By being a part of this movement and using this system, you are contributing in the process of ending all forms of hunger and malnutrition, and ensuring that all people have access to sufficient and nutritious food.
								Investment in infrastructure and technology like ours that helps in hunger eradication will thereby help in reducing food wastage.</p>
							<a href="about.php" class="hvr-rectangle-out button">READ MORE</a>
						</div>
						<div class="clearfix"></div>
					</li>
				</ul>
		</div>
	</div>
</div>
<!-- //banner -->

<!-- welcome -->
<div class="welcome">
	<div class="container">
		<?php

$ret=mysqli_query($con,"select * from tblpages where PageType='aboutus' ");
$cnt=1;
while ($row=mysqli_fetch_array($ret)) {

?>
		<div class="welcome-head">
			
			<p><?php  echo $row['PageDescription'];?></p>
			
		</div>
		
	</div>
	<?php } ?>
</div>
<!-- //welcome -->
<!-- mission -->
<div class="mission">
	<div class="container">
		<div class="mission-header">
			<h3>Have a look at OUR MISSION!</h3> <br> <br> <br> <br> <br>
		</div>
		<div class="mission-grids">
			<div class="col-md-6 mission-left">
				<img src="images/zerowaste1.png" alt=""/>
			</div>


			<div class="col-md-6 mission-right">

				<div class="mis-one">
					<div class="mis-left">
						<img src="images/444-modified.png" alt=""/>
					</div>
					<div class="mis-right">
						<h3>Help and Support</h3>
						<p>By encouraging people to donate food rather than throwing it into the trash, we aim at reducing hunger, malnutrition, and food wastage, thereby saving money, resources, and food. </p>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="mis-one">
					<div class="mis-left">
						<img src="images/555-modified.png" alt=""/>
					</div>
					<div class="mis-right">
						<h3>Helping Hand </h3>
						<p> Join our widespread community of donors which reaches out to the needy and contributes their bit to the society as a responsible citizen. </p>
					</div>
					<div class="clearfix"></div>
				</div>
				
				<div class="mis-one">
					<div class="mis-left">
						<img src="images/666-modified.png" alt=""/>
					</div>
					<div class="mis-right">
						<h3>Starve Free World</h3>
						<p>A globally spread movement, we aspire to see a world which is free from hunger and all diseases caused due to lack of food.</p>
					</div>
					<div class="clearfix"></div>
				</div> </div>
			<div class="clearfix"></div>
		</div>
			<br> <br> <br> <br> <br> <br> <br> 
			<centre>	<iframe width="1175" height="400" src="https://www.youtube.com/embed/2I8Tjb4Fy-Q" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> </centre>
			
	</div>
</div>





<!-- //mission -->

<!-- //success -->
<?php include_once("includes/footer.php");?>
<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->

<script>
 var loader = document.getElementById("preloader");
 window.addEventListener("load", function(){
	loader.style.display = "none";
 })
	</script>

</body>
</html>