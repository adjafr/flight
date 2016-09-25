/* @ngInject */
export default function routes ($stateProvider) {
  $stateProvider
    .state('home', {
      url: '/home',
      component: 'home',
      resolve:{
        allFlights: function(homeSrve){
          return homeSrve.getAllFlights()
        }
    }
})
}
