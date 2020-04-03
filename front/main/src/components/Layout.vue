<template>
    <div>
        <!-- :activeIndex="activeIndex"路由下标亮 -->
        <app-header :activeIndex="activeIndex"></app-header>
        <app-main></app-main>
        <app-contact></app-contact>
        <app-footer></app-footer>
    </div>
</template>
<script>
// 会导入 ./AppHeader 下面的 index.vue组件
import AppHeader from './AppHeader'
import AppMain from './AppMain'
import AppContact from './AppContact'
import AppFooter from './AppFooter'
export default {
    name:'Layout',
    data(){
        return{
            activeIndex: '/',
  			    footerShow:true
        }
    },
    components:{
        AppHeader,AppMain,AppContact,AppFooter
        },

    beforeRouteEnter (to, from, next){
  	    next(vm => {
    	vm.activeIndex = to.path
  	})
    },
    beforeRouteUpdate (to, from, next) {
        if(to.path == '/'){
            this.footerShow = true
        }else{
            this.footerShow = false
        }
        this.activeIndex = to.path
        next()
	}
}
</script>
