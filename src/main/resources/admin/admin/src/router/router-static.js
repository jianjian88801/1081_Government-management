import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import gongwen from '@/views/modules/gongwen/list'
    import huiyishi from '@/views/modules/huiyishi/list'
    import huiyishiYuyue from '@/views/modules/huiyishiYuyue/list'
    import laifangdengji from '@/views/modules/laifangdengji/list'
    import xinfangduban from '@/views/modules/xinfangduban/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryDanwei from '@/views/modules/dictionaryDanwei/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryHuiyishi from '@/views/modules/dictionaryHuiyishi/list'
    import dictionaryHuiyishiYuyue from '@/views/modules/dictionaryHuiyishiYuyue/list'
    import dictionaryHuiyishiYuyueYesno from '@/views/modules/dictionaryHuiyishiYuyueYesno/list'
    import dictionaryLaifangdengjiChuli from '@/views/modules/dictionaryLaifangdengjiChuli/list'
    import dictionaryLaifangdengjiMudi from '@/views/modules/dictionaryLaifangdengjiMudi/list'
    import dictionaryNianhao from '@/views/modules/dictionaryNianhao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryDanwei',
        name: '发出单位',
        component: dictionaryDanwei
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryHuiyishi',
        name: '会议室类型',
        component: dictionaryHuiyishi
    }
    ,{
        path: '/dictionaryHuiyishiYuyue',
        name: '会议室预约类型',
        component: dictionaryHuiyishiYuyue
    }
    ,{
        path: '/dictionaryHuiyishiYuyueYesno',
        name: '审核状态',
        component: dictionaryHuiyishiYuyueYesno
    }
    ,{
        path: '/dictionaryLaifangdengjiChuli',
        name: '是否处理',
        component: dictionaryLaifangdengjiChuli
    }
    ,{
        path: '/dictionaryLaifangdengjiMudi',
        name: '信访目的',
        component: dictionaryLaifangdengjiMudi
    }
    ,{
        path: '/dictionaryNianhao',
        name: '公文年号',
        component: dictionaryNianhao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/gongwen',
        name: '公文',
        component: gongwen
      }
    ,{
        path: '/huiyishi',
        name: '会议室',
        component: huiyishi
      }
    ,{
        path: '/huiyishiYuyue',
        name: '会议室预约',
        component: huiyishiYuyue
      }
    ,{
        path: '/laifangdengji',
        name: '来访登记',
        component: laifangdengji
      }
    ,{
        path: '/xinfangduban',
        name: '信访督办',
        component: xinfangduban
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
