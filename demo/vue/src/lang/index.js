import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Cookies from 'js-cookie'
import enElementLocale from 'element-ui/lib/locale/lang/en'
import enLocale from './en'
import zh_cnElementLocale from 'element-ui/lib/locale/lang/zh-cn'
import zh_cnLocale from './zh-cn'

Vue.use(VueI18n)

const messages = {
  'en': {
    ...enLocale,
    ...enElementLocale
  },
  'zh-cn': {
    ...zh_cnLocale,
    ...zh_cnElementLocale
  }
}



const i18n = new VueI18n({
  locale: Cookies.get('language') || 'en',
  messages
})

export default i18n
