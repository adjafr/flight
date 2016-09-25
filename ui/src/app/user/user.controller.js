import GlobalService from '../global.service'

export default class UserController {
  /* @ngInject */
  constructor (GlobalService) {
    this.name = 'Users'
    this.link = 'userDetail'
    this.glyph = 'user'
    this.GlobalService = 'GlobalService'


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
