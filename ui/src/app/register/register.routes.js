export default function route ($stateProvider) {
  $stateProvider
  

  
    .state('registers', {
      url: '/registers',
      component: 'appRegister'
//    	links to Java Back End below
//      resolve: {
//        entities: function (RegisterService) {
//          return registerService.getAllRegisters()
//        }
//      }
    })
    .state('registerDetail', {
      url: '/registers/:id',
      component: 'appRegisterDetail'
//    	links to java back end below
//      resolve: {
//        entity: function (registerService, $stateParams) {
//          return registerService.getRegister($stateParams.id)
//        }
//      }
    })
}