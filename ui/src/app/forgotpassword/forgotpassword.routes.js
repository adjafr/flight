export default function route ($stateProvider) {
  $stateProvider
  

  
    .state('forgotpasswords', {
      url: '/forgotpasswords',
      component: 'appForgotPassword'
//    	links to Java Back End below
//      resolve: {
//        entities: function (forgotpasswordService) {
//          return forgotpasswordService.getAllForgotPasswords()
//        }
//      }
    })
    .state('forgotpasswordDetail', {
      url: '/forgotpasswords/:id',
      component: 'appForgotPasswordDetail'
//    	links to java back end below
//      resolve: {
//        entity: function (forgotpasswordService, $stateParams) {
//          return forgotpasswordService.getForgotPassword($stateParams.id)
//        }
//      }
    })
}