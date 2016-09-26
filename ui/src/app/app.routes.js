export default function routes ($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/home')  //home
  $stateProvider
    .state('home', //home
    {
      url: '/home', //home

      template: '<flight></flight>',
      // template: '<app-component></app-component>'
      // template: '<app-home></app-home>'
      onEnter: function (GlobalService) {
    		console.dir(GlobalService.loggedIn)
    		console.dir(GlobalService.validUser)
    	}
  })
}
