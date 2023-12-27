import string
import random

def random_text(length):
    hangul = ''.join([chr(random.randint(44032, 55203)) for _ in range(length)])
    alphabets = string.ascii_letters
    combined = [hangul[i // 2] if i % 2 == 0 else random.choice(alphabets) for i in range(length * 2)]
    random.shuffle(combined)
    return ''.join(combined[:length])