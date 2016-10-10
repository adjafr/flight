export default function route ($stateProvider) {
  $stateProvider



    .state('logins', {
      url: '/logins',
      component: 'appLogin'
//    	links to Java Back End below
//      resolve: {
//        entities: function (loginService) {
//          return loginService.getAllLogins()
//        }
//      }
    })
    .state('loginDetail/:id', {
      url: '/users/:id',
      component: 'appLoginDetail'
      })
      // resolve: {allUsers: function(loginService){
      //   return loginService.AllUsers()
      // }
    // }
//    	links to java back end below
//      resolve: {
//        entity: function (loginService, $stateParams) {
//          return loginService.getLogin($stateParams.id)
//        }
//      }

}
