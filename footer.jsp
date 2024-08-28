<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer Design</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap');

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body{
    display: grid;
    justify-content: end;
    align-content: end;
    min-height: 100vh;
}

footer{
    position: relative;
    width: 100%;
    height: auto;
    padding: 50px 100px;
    background: #0d846c;
}

.container1{
    width: 100%;
    display: grid;
    grid-template-columns: 2fr 1fr 1fr 1fr;
    grid-gap: 20px;
}

h2{
    position: relative;
    color: #fff;
    font-weight: 500;
    margin-bottom: 15px;
}

h2::before{
    content:'';
    position: absolute;
    bottom: -5px;
    left: 0;
    width: 50px;
    height: 2px;
    background: #fb923c;
}

p1{
    color: #fff
}

.sci{
    margin-top: 20px;
    display:grid;
    grid-template-columns: repeat(4,50px);
    grid-gap: 10px;
}

.sci li{
    list-style: none;
}
.sci li a{
    display: inline-block;
    width: 48px;
    height:48px;
    background: #12ac8e;
    display: grid;
    align-content: center;
    justify-content: center;
    text-decoration: none;
    border-radius: 10px;
}

.sci li a:hover{
    background: #fb923c;
}

.sci li a .fab{
    color: #fff;
    font-size: 20px;
}

.quicklinks{
    position: relative;

}
.quicklinks li{
    list-style: none;
}

.quicklinks li a{
    color: #f7f7f7;
    text-decoration: none;
    margin-bottom: 10px;
    display: inline-block;
}
.quicklinks li a:hover{
    color: #fb923c;
}
.info{
    position: relative;
}
.info li{
    display:grid;
    grid-template-columns: 30px 1fr;
    margin-bottom: 16px;
}
.info li span:nth-child(1){
    color: #fb923c;
    font-size: 20px;

}
.info li span{
    color: #fff;
}
.info a{
    color:#f7f7f7;
    text-decoration: none;
}
.info a:hover{
    color: #fb923c;
}
.copyrightText{
    width:100%;
    background: #000303;
    padding: 8px 100px;
    text-align: center;
    color: #fff;
}

/* responsive */
@media (max-width:991px){
    footer{
        padding: 40px;
    }
    footer.container{
        grid-template-columns: repeat(2,1fr);
    }
    .copyrightText{
        padding: 8px 40px;
    }
}
@media (max-width:768px){
    footer.container{
        grid-template-columns: repeat(1,1fr);
    }

}
</style>
</head>

<body>

    <footer>

        <div class="container1">

            <div class="sec aboutus">

                <h2>About Us</h2>
                <p1>We are committed to providing compassionate and high-quality healthcare to our community.At HealStation, we are dedicated to providing exceptional healthcare services tailored to meet the unique needs of our patients.</p1>

                <ul class="sci">
                    <li>
                        <a href="https://www.facebook.com/profile.php?id=61559741001647" target="_blank">
                            <i class="fab fa-facebook" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.instagram.com/rayaaaa.art?igsh=MWl5eGV2d3dnM2psaQ==" target="_blank">
                            <i class="fab fa-instagram" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fab fa-twitter" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://youtube.com/@ApnaCollegeOfficial?si=GHYG76oEVuThpGwm" target="_blank">
                            <i class="fab fa-youtube" aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="sec quicklinks">

                <h2>Quick Links</h2>
                <ui>
                    <li><a href ="about_us.html">About</a></li>
                    <li><a href ="faq.html">FAQ</a></li>
                    <li><a href ="privacy_policy.html">Privacy Policy</a></li>
                    <li><a href ="terms_conditions.html">Terms & Conditions</a></li>
                    <li><a href ="contact_us.html">Contact us</a></li>
                </ui>
            </div>

            <div class="sec quicklinks">

                <h2>Patient Services</h2>
                <ui>
                	<li><a href ="user_login.jsp">Patient Login</a></li>
                	<li><a href ="find_doctor.jsp">Find a Doctor</a></li>
                	<li><a href ="appointment_userDetails.jsp">Book Appointment</a></li>                                                           
                    <li><a href ="feedback.html">Feedback</a></li>                    
                </ui>
            </div>

            <div class="sec contact">

                <h2>Contact Us</h2>
                <ul class="info">
                	 <li>
                        <span><i class="fa fa-envelope" aria-hidden="true"></i></span>
                        <p1><a href="#">healstation@gmail.com</a></p1>
                    </li>                    
                    <li>
                        <span><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <p1><a href="#">2441139</a></p1>
                    </li>
                    <li>
                        <span><i class="fa fa-map-marker" aria-hidden="true"></i></span>
                        <span>66, Harrison Road<br>
                        Kolkata<br>West Bengal</span>
                    </li>
                </ul>
            </div>

        </div>
    </footer>

    <div class="copyrightText">
        <p1>Copyright © 2023 Team SPARS. All Rights Reserved.</p1>
    </div>
    
</body>
</html>