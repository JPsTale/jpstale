(function () {
  var form = document.getElementById('registerForm');
  var msgEl = document.getElementById('msg');
  var submitBtn = document.getElementById('submitBtn');

  function showMsg(text, isError) {
    msgEl.textContent = text;
    msgEl.className = 'msg ' + (isError ? 'error' : 'success');
    msgEl.classList.remove('hidden');
  }

  function hideMsg() {
    msgEl.classList.add('hidden');
  }

  // 与登录一致：SHA256(UPPERCASE(account)+":"+明文密码) 十六进制大写，前端计算后传后端存库
  function sha256Hex(str) {
    return crypto.subtle.digest('SHA-256', new TextEncoder().encode(str))
      .then(function (buf) {
        var arr = new Uint8Array(buf);
        var hex = '';
        for (var i = 0; i < arr.length; i++) {
          hex += ('0' + arr[i].toString(16)).slice(-2).toUpperCase();
        }
        return hex;
      });
  }

  form.addEventListener('submit', function (e) {
    e.preventDefault();
    hideMsg();

    var account = (document.getElementById('account').value || '').trim();
    var email = (document.getElementById('email').value || '').trim();
    var password = document.getElementById('password').value;
    var passwordConfirm = document.getElementById('passwordConfirm').value;

    if (!account) {
      showMsg('请输入账号', true);
      return;
    }
    if (account.length > 32) {
      showMsg('账号长度不能超过 32 个字符', true);
      return;
    }
    if (!email) {
      showMsg('请输入邮箱', true);
      return;
    }
    if (email.length > 150) {
      showMsg('邮箱长度不能超过 150 个字符', true);
      return;
    }
    var emailRe = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRe.test(email)) {
      showMsg('请输入有效的邮箱地址', true);
      return;
    }
    if (!password) {
      showMsg('请输入密码', true);
      return;
    }
    if (password !== passwordConfirm) {
      showMsg('两次输入的密码不一致', true);
      return;
    }

    submitBtn.disabled = true;

    var input = account.toUpperCase() + ':' + password;
    sha256Hex(input).then(function (passwordHash) {
      return fetch('/api/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ account: account, email: email, password: passwordHash })
      });
    })
      .then(function (res) { return res.json(); })
      .then(function (data) {
        if (data.success) {
          showMsg(data.message || '注册成功，请使用游戏客户端登录。');
          form.reset();
        } else {
          showMsg(data.message || '注册失败', true);
        }
      })
      .catch(function () {
        showMsg('网络错误，请稍后重试', true);
      })
      .finally(function () {
        submitBtn.disabled = false;
      });
  });
})();
