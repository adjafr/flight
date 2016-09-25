import home from './home.component'
// import routes from './home.routes'
import homeService from '../service/home.service'



export default
  angular
    .module('homeApp', [])
    .component('home', home)
    .service('homeSrve', homeService)
    // .config(routes)
    .name
