<template>
	<el-footer class="me-area">
		<div class="me-footer">
      <div >
        <span>Copyright © 2020河南省中原工学院计算机学院 </span>
      </div>
		</div>
	</el-footer>
  
</template>

<script>
	
export default {
  name: 'AppFooter',
  data (){
  	return {
  	}
  },
  methods:{
	},
}
</script>

<style>

.el-footer {
  min-width: 100%;
  box-shadow: 0 -2px 3px hsla(0,0%,7%,.1), 0 0 0 1px hsla(0,0%,7%,.1);
  position:absolute;
  bottom:0;
  left:0;
  z-index: 1024;
}
.me-footer{
  text-align: center;
  line-height: 50px;
  font-family: 'Open Sans', sans-serif;
  font-size: 18px;
  
}
.me-login-design-color{
  color: #5FB878 !important;
}
  
</style>
