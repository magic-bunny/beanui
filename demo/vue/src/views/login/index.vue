<script>
import { getToken, setToken, removeToken } from '@/utils/auth'
export default {
  name: 'login',
  created() {
    this.$store.dispatch('LoginByAnonymous').then(() => {
      this.$router.push({ path: '/' })
    })
  }
}
</script>
