import GlobalService from '../global.service'

export default class UserController {
  /* @ngInject */
  constructor ($scope, GlobalService, UserDetailService) {
    this.name = 'Users'
    this.link = 'userDetail'
    this.glyph = 'user'
    this.GlobalService = 'GlobalService'
    this.flight

    this.findFlight = function () {
      UserDetailService.createItinerary(this.flight).then(function(promise){
        $scope.flights=promise.data
          console.dir($scope.flights)
          $scope.flightList;
          for(var i=0; i < promise.data.length; i++) {
            $scope.mapdata = promise.data[i];
            $scope.flightList.push(mapdata);
          }
          console.log($scope.flightList);

      })

    }


    var bcrypt = require('bcryptjs');

    if (this.entity) {
      this.info = {
        User: this.entity.user,
        // Tweet: this.entity.tweet
      }
      // this.setInfo = {
      //   Tweets: this.entity.tweets,
      //   Tweets: this.entity.tweets
      // }
    }
  }

  getLink (name) {
    if (name === 'User') {
      return 'userDetail'
    } else if (name === 'Tweet') {
      return 'tweetDetail'
    }
  }

  getGlyph (name) {
    if (name === 'User') {
      return 'flag'
    } else if (name === 'Tweet') {
      return 'home'
    }
  }







}
